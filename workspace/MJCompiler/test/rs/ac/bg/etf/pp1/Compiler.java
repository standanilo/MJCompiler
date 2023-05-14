package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java_cup.runtime.Symbol;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.util.Log4JUtils;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.*;

public class Compiler {

	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}
	
	static void tsdump() {
		Tab.dump();
	}
	
	public static void main(String[] args) throws Exception {
		
		Logger log = Logger.getLogger(Compiler.class);
		
		if (args.length < 2) {
			log.error("Not enough arguments to start!");
			return;
		}
		
		Reader br = null;
		try {
			File sourceCode = new File(args[0]);

//			PrintStream o = new PrintStream(new File("test/pozivFunkc.out"));
//			PrintStream err = new PrintStream(new File ("test/pozivFunkc.err"));
//			System.setOut(o);
//			System.setErr(err);
			
			log.info("Compiling source file: " + sourceCode.getAbsolutePath());

			br = new BufferedReader(new FileReader(sourceCode));
			Yylex lexer = new Yylex(br);
			
			MJParser p = new MJParser(lexer);
	        Symbol s = p.parse();  // pocetak parsiranja
	        
	        Program prog = (Program)(s.value); 
	        Tab.init();
			// ispis sintaksnog stabla
			log.info(prog.toString(""));
			log.info("===================================");

			// ispis prepoznatih programskih konstrukcija
			SemanticAnalyzer sa = new SemanticAnalyzer();
			prog.traverseBottomUp(sa); 
			
			log.info("===================================");
			tsdump();
			
			log.info("===================================");
			log.info("Number of declared constants: " + sa.constants);
			log.info("Number of used constants: " + sa.constantsUsed);
			log.info("Number of declared global variables: " + sa.globalVars);
			log.info("Number of used global variables: " + sa.globalVarsUsed);
			log.info("Number of declared local variables: " + sa.localVars);
			log.info("Number of used local variables: " + sa.localVarsUsed);
			log.info("Number of variables: " + sa.nVars);
			log.info("===================================");
			
			if (!p.errorDetected && sa.passed()) {
				File objFile = new File(args[1]);
				if(objFile.exists()) {
					objFile.delete();
				}
				
				CodeGenerator cg = new CodeGenerator();
				prog.traverseBottomUp(cg);
				Code.dataSize = sa.nVars;
				Code.mainPc = cg.getMainPc();
				Code.write(new FileOutputStream(objFile));
				log.info("Parsing completed successfully!");
			} else {
				log.error("Parsing failed!");
			}
			
		} 
		finally {
			if (br != null) try { br.close(); } catch (IOException e1) { log.error(e1.getMessage(), e1); }
		}

	}
	
	
}
