package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticPass extends VisitorAdaptor {

	public static final Struct boolType = new Struct(Struct.Bool);

	Logger log = Logger.getLogger(getClass());

	boolean errorDetected = false;
	Struct currentType = null;
	Obj currentClass = null;
	Struct parentClass = null;
	Obj currentMethod = null;
	int numPars = 0;
	Scope topLevelScope = null;
	List<Obj> designatorsLeft = null;
	boolean relop = false;
	Map<Integer, Struct> actParams = null;
	List<Obj> designatorsRight = null;
	Obj designatorArray = null;
	Map<String, Obj> classes = new HashMap<>();
	boolean returnFound = false;
	boolean left = true;
	Struct designatorType = null;

	int constants = 0;
	int constantsUsed = 0;
	int globalVars = 0;
	int globalVarsUsed = 0;
	int localVars = 0;
	int localVarsUsed = 0;
	int nVars;

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" in line ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" in line ").append(line);
		log.info(msg.toString());
	}

	public void visit(ProgName progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
		Tab.openScope();
		topLevelScope = Tab.currentScope;
	}

	public void visit(Program program) {
		nVars = Tab.currentScope.getnVars();
		Obj main = Tab.find("main");
		if (main == Tab.noObj) {
			report_error("Error: Main method not found", program);
		}
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
	}

	public void visit(Type type) {
		Obj typeNode = Tab.find(type.getTypeName());
		if (typeNode == Tab.noObj) {
			if (type.getTypeName().equals("bool"))
				typeNode = Tab.insert(Obj.Type, "bool", boolType);
			else {
				report_error("Error: Type " + type.getTypeName() + " is not defined", null);
				type.struct = Tab.noType;
			}
		}
		if (Obj.Type == typeNode.getKind()) {
			type.struct = typeNode.getType();
			currentType = type.struct;
		} else {
			report_error("Error: " + type.getTypeName() + " is not a type", null);
			type.struct = Tab.noType;
		}
	}

	public void visit(ConstNumber number) {
		Obj numberNode = Tab.currentScope().findSymbol(number.getNumbers());
		if (numberNode == null) {
			if (currentType.getKind() == Struct.Int) {
				numberNode = Tab.insert(Obj.Con, number.getNumbers(), Tab.intType);
				numberNode.setAdr(number.getNum());
				report_info("Integer constant " + number.getNumbers() + " declared", number);
				constants++;
			} else {
				report_error("Error: Constant " + number.getNumbers() + " is of the wrong type", number);
			}
		} else {
			report_error("Error: " + number.getNumbers() + " already declared", number);
		}
	}

	public void visit(ConstBool b) {
		Obj boolNode = Tab.currentScope().findSymbol(b.getBooleans());
		if (boolNode == null) {
			if (currentType.getKind() == Struct.Bool) {
				boolNode = Tab.insert(Obj.Con, b.getBooleans(), boolType);
				if (b.getBool().equals("true")) {
					boolNode.setAdr(1);
				} else {
					boolNode.setAdr(0);
				}
				report_info("Boolean constant " + b.getBooleans() + " declared", b);
				constants++;
			} else {
				report_error("Error: Constant " + b.getBooleans() + " is of the wrong type", b);
			}
		} else {
			report_error("Error: " + b.getBooleans() + " already declared", b);
		}
	}

	public void visit(ConstChar c) {
		Obj charNode = Tab.currentScope().findSymbol(c.getCharacters());
		if (charNode == null) {
			if (currentType.getKind() == Struct.Char) {
				charNode = Tab.insert(Obj.Con, c.getCharacters(), Tab.charType);
				charNode.setAdr(c.getC().charValue());
				report_info("Character constant " + c.getCharacters() + " declared", c);
				constants++;
			} else {
				report_error("Error: Constant " + c.getCharacters() + " is of the wrong type", c);
			}
		} else {
			report_error("Error: " + c.getCharacters() + " already declared", c);
		}
	}

	public void visit(NoArrayGlobalVarDeclarations gvd) {
		Obj node = topLevelScope.findSymbol(gvd.getVarName());
		if (node == null) {
			if (currentType != Tab.noType) {
				Obj varNode = Tab.insert(Obj.Var, gvd.getVarName(), currentType);
				varNode.setLevel(0);
				report_info("Global variable " + gvd.getVarName() + " declared", gvd);
				globalVars++;
			} else {
				report_error("Error: Type not listed", gvd);
			}
		} else {
			report_error("Error: " + gvd.getVarName() + " already declared in global scope", gvd);
			;
		}
	}

	public void visit(ArrayGlobalVarDeclarations gvd) {
		Obj node = topLevelScope.findSymbol(gvd.getVarName());
		if (node == null) {
			if (currentType != Tab.noType) {
				Obj varNode = Tab.insert(Obj.Var, gvd.getVarName(), new Struct(Struct.Array, currentType));
				varNode.setLevel(0);
				report_info("Global array " + gvd.getVarName() + " declared", gvd);
				globalVars++;
			} else {
				report_error("Error: Type not listed", gvd);
			}
		} else {
			report_error("Error: " + gvd.getVarName() + " already declared in global scope", gvd);
			;
		}
	}

	public void visit(NoArrayVarDeclarations gvd) {
		Obj node = Tab.currentScope().findSymbol(gvd.getVarName());
		if (node == null) {
			if (currentType != Tab.noType) {
				if (currentClass == null) {
					Obj varNode = Tab.insert(Obj.Var, gvd.getVarName(), currentType);
					varNode.setLevel(1);
					report_info("Local variable " + gvd.getVarName() + " declared", gvd);
					localVars++;
				} else {
					Obj varNode = Tab.insert(Obj.Fld, gvd.getVarName(), currentType);
					varNode.setLevel(1);
					report_info("Class field " + gvd.getVarName() + " declared", gvd);
				}
			} else {
				report_error("Error: Type not listed", gvd);
			}
		} else {
			report_error("Error: " + gvd.getVarName() + " already declared", gvd);
			;
		}
	}

	public void visit(ArrayVarDeclarations gvd) {
		Obj node = Tab.currentScope().findSymbol(gvd.getVarName());
		if (node == null) {
			if (currentType != Tab.noType) {
				if (currentClass == null) {
					Obj varNode = Tab.insert(Obj.Var, gvd.getVarName(), new Struct(Struct.Array, currentType));
					varNode.setLevel(1);
					report_info("Local array " + gvd.getVarName() + " declared", gvd);
					localVars++;
				} else {
					Obj varNode = Tab.insert(Obj.Fld, gvd.getVarName(), new Struct(Struct.Array, currentType));
					varNode.setLevel(1);
					report_info("Class array " + gvd.getVarName() + " declared", gvd);
				}
			} else {
				report_error("Error: Type not listed", gvd);
			}
		} else {
			report_error("Error: " + gvd.getVarName() + " already declared", gvd);
			;
		}
	}

	public void visit(ClassName cn) {
		Obj node = Tab.currentScope().findSymbol(cn.getClassN());
		if (node == null) {
			cn.obj = Tab.insert(Obj.Type, cn.getClassN(), new Struct(Struct.Class));
			if (Tab.currentScope == topLevelScope) {
				classes.put(cn.getClassN(), node);
			}
			Tab.openScope();
			currentClass = node;
		} else {
			report_error("Error: " + cn.getClassN() + " already declared", cn);
		}
	}

	public void visit(ClassDeclarations cd) {
		Tab.chainLocalSymbols(cd.getClassName().obj);
		Tab.closeScope();
		report_info("Class " + cd.getClassName() + " declared", cd);
		currentClass = null;
	}

	public void visit(ClassExtend ce) {
		Obj node = Tab.find(ce.getType().getTypeName());
		Obj cl = classes.get(ce.getType().getTypeName());
		if ((node != Tab.noObj) && (cl != null)) {
			report_info("Class extended successfully", ce);
		} else {
			report_error("Error: Parent class " + ce.getType().getTypeName() + " is not program's inner class", ce);
		}
	}

	public void visit(ReturnType rt) {
		Obj node = Tab.currentScope().findSymbol(rt.getMethodName());
		if (node == null) {
			rt.obj = Tab.insert(Obj.Meth, rt.getMethodName(), rt.getType().struct);
			currentMethod = rt.obj;
			report_info("Method " + rt.getMethodName() + " declared", rt);
			if (currentMethod.getName().equals("main")) {
				report_error("Error: Main method must be void", rt);
			}
			Tab.openScope();
		} else {
			report_error("Error: " + rt.getMethodName() + " already declared", rt);
		}
	}

	public void visit(ReturnVoid rv) {
		Obj node = Tab.currentScope().findSymbol(rv.getMethodName());
		if (node == null) {
			rv.obj = Tab.insert(Obj.Meth, rv.getMethodName(), Tab.noType);
			currentMethod = rv.obj;
			report_info("Method " + rv.getMethodName() + " declared", rv);
			Tab.openScope();
		} else {
			report_error("Error: " + rv.getMethodName() + " already declared", rv);
		}
	}

	public void visit(MethodDecls md) {
		if (currentMethod != null) {
			if (currentMethod.getType() == Tab.noType && returnFound) {
				report_error("Error: Method must not have return", md);
			} else if (currentMethod.getType() != Tab.noType && !returnFound) {
				report_error("Error: Missing return statement", md);
			}

			Tab.chainLocalSymbols(currentMethod);
			Tab.closeScope();

			report_info("Method " + currentMethod.getName() + " processed", md);

			currentMethod.setLevel(numPars);

			returnFound = false;
			currentMethod = null;
			numPars = 0;
		}
	}

	public void visit(ParamsDeclarations pd) {
		if (currentMethod.getName().equals("main")) {
			report_error("Error: Main method must have no arguments", pd);
		} else {
			report_info("Formal parameters for method " + currentMethod.getName() + " declared", pd);
		}
	}

	public void visit(FormalParam fp) {
		Obj node = Tab.currentScope().findSymbol(fp.getParamName());
		if (node == null) {
			if (currentType != Tab.noType) {
				Obj varNode = Tab.insert(Obj.Var, fp.getParamName(), currentType);
				numPars++;
				varNode.setFpPos(numPars);
				report_info("Formal parameter" + fp.getParamName() + " declared", fp);
			} else {
				report_error("Error: Type not listed", fp);
			}
		} else {
			report_error("Error: " + fp.getParamName() + " already declared", fp);
		}
	}

	public void visit(FormalParamArray fp) {
		Obj node = Tab.currentScope().findSymbol(fp.getParamName());
		if (node == null) {
			if (currentType != Tab.noType) {
				Obj varNode = Tab.insert(Obj.Var, fp.getParamName(), new Struct(Struct.Array, currentType));
				numPars++;
				report_info("Formal array parameter " + fp.getParamName() + " declared", fp);
			} else {
				report_error("Error: Type not listed", fp);
			}
		} else {
			report_error("Error: " + fp.getParamName() + " already declared", fp);
		}
	}

	public void visit(ArrayElemDesignator aem) {
		Obj o = aem.getDesignatorName().obj;
		Struct exp = aem.getExpr().struct;
		Struct arrayStruct = o.getType();

		aem.obj = new Obj(Obj.Elem, "elem", arrayStruct.getElemType());

		if (arrayStruct.getKind() == Struct.Array) {
			if (exp.getKind() == Struct.Int) {
				report_info("Accessing array element", aem);
			} else {
				report_error("Error: Expression must be int type", aem);
			}
		} else {
			aem.obj = Tab.noObj;
			report_error("Error: Variable must be array", aem);
		}
	}

	public void visit(FieldDesignator fd) {
		fd.obj = fd.getDesignatorName().obj;
		Obj node = fd.obj;
		if (node == null || node == Tab.noObj) {
			report_error("Error: Class " + fd.getDesignatorName().getVarName() + " not declared", fd);
		} else {
			if (node.getType().getKind() == Struct.Class) {
				currentClass = node;
				parentClass = currentClass.getType().getElemType();
				node = Tab.find(fd.getElemName());
				if (node == Tab.noObj) {
					report_error("Error: Class field " + fd.getElemName() + " not declared", fd);
				} else {
					currentType = node.getType();
					report_info("Accessing a class field", fd);
				}
			} else {
				report_error("Error: DST variable must be class", fd);
			}

		}
	}

	public void visit(SingleDesignator sd) {
		sd.obj = sd.getDesignatorName().obj;
		if (sd.getParent().getClass() == DesignatorAssign.class) {
			designatorType = sd.obj.getType().getElemType();
		}
	}

	public void visit(DesignatorName dn) {
		dn.obj = Tab.currentScope().findSymbol(dn.getVarName());
		if (dn.obj == null) {
			dn.obj = Tab.currentScope().getOuter().findSymbol(dn.getVarName());
			if (dn.obj == null) {
				report_error("Error: " + dn.getVarName() + " not declared", dn);
				dn.obj = Tab.noObj;
			} else {
				report_info(dn.getVarName() + " used", dn);
			}
		}
		if (dn.obj.getKind() == Obj.Con) {
			constantsUsed++;
		} else if (dn.obj.getKind() == Obj.Var && dn.obj.getLevel() == 0) {
			globalVarsUsed++;
		} else if (dn.obj.getKind() == Obj.Var && (dn.obj.getLevel() == 1 || dn.obj.getLevel() == 2)) {
			localVarsUsed++;
		}
	}

	public void visit(FactorNewExpr fne) {
		if (fne.getExpr().struct.getKind() != Struct.Int) {
			report_error("Error: Expression must be int type", fne);
		}
		fne.struct = fne.getExpr().struct;
	}

	public void visit(FactorNew fn) {
		if (designatorType != fn.getType().struct) {
			report_error("Error: Designator must be same type", fn);
		}
		if (fn.getExprOrActPars().struct.getKind() == Struct.Int) {
			fn.struct = new Struct(Struct.Array, Tab.intType);
		} else {
			report_error("Error: Index must be int type", fn);
		}
	}

	public void visit(FactorNumber fn) {
		fn.struct = Tab.intType;
		constantsUsed++;
	}

	public void visit(FactorBool fb) {
		fb.struct = boolType;
		constantsUsed++;
	}

	public void visit(FactorChar fc) {
		fc.struct = Tab.charType;
		constantsUsed++;
	}

	public void visit(FactorExpr fe) {
		fe.struct = fe.getExpr().struct;
	}

	public void visit(FactorDesignator fd) {
		if (fd.getDesignator().obj == null) {
			report_error("Error: Variable not declared", fd);
			fd.struct = Tab.noType;
		} else {
			fd.struct = fd.getDesignator().obj.getType();
		}
	}

	public void visit(FactorOne fo) {
		fo.struct = fo.getFactor().struct;
	}

	public void visit(MultipleFactors mf) {
		if (mf.getMulopFactorList().struct.getKind() != Struct.Int || mf.getFactor().struct.getKind() != Struct.Int) {
			report_error("Error: Must be int type", mf);
		}
		mf.struct = mf.getMulopFactorList().struct;
	}

	public void visit(Term term) {
		term.struct = term.getMulopFactorList().struct;
	}

	public void visit(MultipleTerms mt) {
		if (mt.getAddopTermList().struct.getKind() != Struct.Int || mt.getTerm().struct.getKind() != Struct.Int) {
			report_error("Error: Must be int type", mt);
		}
		mt.struct = mt.getTerm().struct;
	}

	public void visit(TermOne to) {
		to.struct = to.getTerm().struct;
	}

	public void visit(MinusExpr me) {
		if (me.getAddopTermList().struct.getKind() != Struct.Int) {
			report_error("Error: Must be int type", me);
		}
		me.struct = me.getAddopTermList().struct;
	}

	public void visit(NoMinusExpr nme) {
		nme.struct = nme.getAddopTermList().struct;
	}

	public void visit(CompareExpression ce) {
		if (ce.getExpr().struct.getKind() == ce.getExpr1().struct.getKind()) {
			if ((ce.getExpr().struct.getKind() == Struct.Array && ce.getExpr1().struct.getKind() == Struct.Array)
					|| (ce.getExpr().struct.getKind() == Struct.Array && ce.getExpr1().struct == Tab.nullType)) {
				// == or != used
				if (relop) {
					report_info("Expressions compared", ce);
				} else {
					report_error("Error: Cannot use this operator to compare expressions", ce);
				}
			}
			relop = false;
			ce.struct = ce.getExpr().struct;
		} else {
			report_error("Error: Incompatible types", ce);
		}
	}

	public void visit(OneExpression oe) {
		oe.struct = oe.getExpr().struct;
	}

	public void visit(Condition c) {
		c.struct = new Struct(Struct.Bool);
	}

	public void visit(RelopEq re) {
		relop = true;
	}

	public void visit(RelopNeq rn) {
		relop = true;
	}

	public void visit(LBracket lb) {
		actParams = new HashMap<>();
	}

	public void visit(RBracket rb) {
		actParams = null;
	}

	public void visit(ActPars ap) {
		actParams.put(actParams.size() + 1, ap.getExpr().struct);
		report_info("Actual parameter added", ap);
	}

	public void visit(SomeActPars apl) {
		if (((DesignatorActPars) apl.getParent()).getDesignator().obj.getKind() != Obj.Meth) {
			report_error("Error: " + ((DesignatorActPars) apl.getParent()).getDesignator().obj.getName()
					+ " is not a method", apl);
		} else {
			int numPars = ((DesignatorActPars) apl.getParent()).getDesignator().obj.getLevel();
			if (numPars != actParams.size()) {
				report_error("Error: Wrong number of arguments in method call", apl);
			} else {
				Collection<Obj> objs = ((DesignatorActPars) apl.getParent()).getDesignator().obj.getLocalSymbols();
				int i = 1;
				for (Obj o : objs) {
					Struct s = actParams.get(o.getFpPos());
					if ((o.getFpPos() != 0) && (o.getType() != s)) {
						if (o.getType().getKind() == Struct.Array && s == Tab.nullType) {

						} else {
							report_error("Error: Incompatible argument types", apl);
						}
					}
					i++;
				}
			}
		}
	}

	public void visit(DesignatorActPars dap) {
		Obj function = dap.getDesignator().obj;
		if (function.getKind() != Obj.Meth) {
			report_error("Error: " + function.getName() + " is not a method", dap);
		} else {
			if (function.getType() == Tab.noType) {
				report_error("Error: " + function.getName() + " does not have a return value", dap);
			} else {
				report_info(function.getName() + " function call found", dap);
			}
		}
	}

	public void visit(ReadStatement rs) {
		Obj designator = rs.getDesignator().obj;
		if (designator.getKind() == Obj.Var || designator.getKind() == Obj.Elem) {
			if ((designator.getType().getKind() == Struct.Bool) || (designator.getType().getKind() == Struct.Char)
					|| (designator.getType().getKind() == Struct.Int)) {
				report_info("'read' method called", rs);
			} else {
				report_error("Error: Wrong variable type", rs);
			}
		} else {
			report_error("Error: " + designator.getName() + " must be variable or array element", rs);
		}
	}

	public void visit(PrintStatement ps) {
		Struct exp = ps.getExpr().struct;
		Struct nums = ps.getNumbers().struct;
		if (exp != null) {
			if ((exp.getKind() == Struct.Bool) || (exp.getKind() == Struct.Int) || (exp.getKind() == Struct.Char)) {
				report_info("'print' method called", ps);
			} else {
				report_error("Error: Expression must be of int, char or bool type", ps);
			}
		} else {
			report_error("Error: Expression must be of int, char or bool type", ps);
		}
	}

	public void visit(ReturnsExpr re) {
		if (currentMethod != null) {
			if (currentMethod.getType() == re.getExpr().struct) {
				returnFound = true;
				report_info("'return' found", re);
			} else {
				report_error("Error: Return type must match method", re);
			}
		} else {
			report_error("Error: 'return' outside of method", re);
		}
	}

	public void visit(ReturnsVoid rv) {
		if (currentMethod != null) {
			if (currentMethod.getType() == Tab.noType) {
				report_info("'return' found", rv);
			} else {
				report_error("Error: Return type is void", rv);
			}
		} else {
			report_error("Error: 'return' outside of method", rv);
		}
	}

	public void visit(NoNumbers nn) {
		nn.struct = Tab.noType;
	}

	public void visit(MoreNumbers mn) {
		mn.struct = Tab.intType;
		constantsUsed++;
	}

	public void visit(DesignatorAssign da) {
		Obj designator = da.getDesignator().obj;
		Struct exp = da.getExpr().struct;
		if (designator != null && exp != null) {
			if (designator.getKind() == Obj.Var || designator.getKind() == Obj.Elem) {
				if (designator.getType().getKind() == exp.getKind()) {
					report_info("Assign statement found", da);
				} else if ((designator.getType().getKind() == Struct.Array
						|| designator.getType().getKind() == Struct.Class) && exp == Tab.nullType) {
					report_info("Assign statement found", da);
				} else {
					report_error("Error: Incompatible types", da);
				}
			} else {
				report_error("Error: " + designator.getName() + " must be variable or array element", da);
			}
		}
	}

	public void visit(DesignatorInc di) {
		Obj designator = di.getDesignator().obj;
		if (designator.getKind() == Obj.Var || designator.getKind() == Obj.Elem) {
			if (designator.getType() == Tab.intType) {
				report_info("Increment found", di);
			} else {
				report_error("Error: " + designator.getName() + " must be of int type", di);
			}
		} else {
			report_error("Error: " + designator.getName() + " must be variable or array element", di);
		}
	}

	public void visit(DesignatorDec dd) {
		Obj designator = dd.getDesignator().obj;
		if (designator.getKind() == Obj.Var || designator.getKind() == Obj.Elem) {
			if (designator.getType() == Tab.intType) {
				report_info("Decrement found", dd);
			} else {
				report_error("Error: " + designator.getName() + " must be of int type", dd);
			}
		} else {
			report_error("Error: " + designator.getName() + " must be variable or array element", dd);
		}
	}

	public void visit(DesignatorArray da) {
		for (Obj o : designatorsLeft) {
			if (o.getKind() == Obj.Var || o.getKind() == Obj.Elem) {
				report_info("Array assignment found", da);
			} else {
				report_error("Error: " + o.getName() + " must be variable or array element", da);
			}
		}
		if (designatorsRight != null) {
			for (int i = 0; i < designatorsLeft.size(); i++) {
				if (designatorsRight.size() - 1 < i) {
					break;
				}
				if (designatorsLeft.get(i) == Tab.noObj) {
					report_info("Empty element found", da);
				} else if (designatorsLeft.get(i).getType() == designatorsRight.get(i).getType()) {

				} else {
					report_error("Error: Incompatible types", da);
				}
			}

		} else if (designatorArray != null) {
			if (designatorArray.getType().getKind() == Struct.Array) {

			} else {
				report_error("Error: " + designatorArray.getName() + " must be an array", da);
			}
		}
		designatorsLeft = null;
		designatorsRight = null;
		designatorArray = null;
	}

	public void visit(LBracketD1 lb) {
		left = true;
		designatorsLeft = new ArrayList<>();
	}

	public void visit(RBracketD1 rb) {
		left = false;
	}

	public void visit(LBracketD2 lb) {
		designatorsRight = new ArrayList<>();
	}

	public void visit(RBracketD2 rb) {
		left = true;
	}

	public void visit(NoDesignators nd) {
		designatorsLeft.add(Tab.noObj);
	}

	public void visit(SingleDesignators sd) {
		sd.obj = sd.getDesignator().obj;
		designatorsLeft.add(sd.obj);
	}

	public void visit(DesignatorNL dnl) {
		dnl.obj = dnl.getDesignator().obj;
		designatorsRight.add(dnl.obj);
	}

	public void visit(ArrayDesignator ad) {
		designatorArray = ad.getDesignatorName().obj;
	}

	public boolean passed() {
		return !errorDetected;
	}
}
