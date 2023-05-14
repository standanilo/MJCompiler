package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.etf.pp1.CounterVisitor.FormParamCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.*;

public class CodeGenerator extends VisitorAdaptor {

	private int mainPc;
	List<Integer> nums = new ArrayList<>();
	boolean printTrue;
	boolean typeInt;
	boolean left = true;
	Obj designatorArray = null;
	List<Obj> designatorsRight = null;
	List<Obj> designatorsLeft = null;

	public int getMainPc() {
		return mainPc;
	}

	// ============================PROGRAM AND METHODS==============================

	public void visit(ProgName progName) {

		Obj ord = Tab.find("ord");
		ord.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(1);
		Code.put(1);
		Code.put(Code.load);
		Code.put(0);
		Code.put(Code.exit);
		Code.put(Code.return_);

		Obj chr = Tab.find("chr");
		chr.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(1);
		Code.put(1);
		Code.put(Code.load);
		Code.put(0);
		Code.put(Code.exit);
		Code.put(Code.return_);

		Obj len = Tab.find("len");
		len.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(1);
		Code.put(1);
		Code.put(Code.load);
		Code.put(0);
		Code.put(Code.arraylength);
		Code.put(Code.exit);
		Code.put(Code.return_);

	}

	public void visit(ReturnType rt) {
		if ("main".equalsIgnoreCase(rt.getMethodName())) {
			mainPc = Code.pc;
		}
		rt.obj.setAdr(Code.pc);

		// Collect arguments and local variables
		SyntaxNode methodNode = rt.getParent();

		VarCounter vc = new VarCounter();
		methodNode.traverseTopDown(vc);

		FormParamCounter fpc = new FormParamCounter();
		methodNode.traverseTopDown(fpc);

		// Generate the entry
		Code.put(Code.enter);
		Code.put(fpc.getCount());
		Code.put(fpc.getCount() + vc.getCount());

	}

	public void visit(ReturnVoid rv) {
		if ("main".equalsIgnoreCase(rv.getMethodName())) {
			mainPc = Code.pc;
		}
		rv.obj.setAdr(Code.pc);

		// Collect arguments and local variables
		SyntaxNode methodNode = rv.getParent();

		VarCounter vc = new VarCounter();
		methodNode.traverseTopDown(vc);

		FormParamCounter fpc = new FormParamCounter();
		methodNode.traverseTopDown(fpc);

		// Generate the entry
		Code.put(Code.enter);
		Code.put(fpc.getCount());
		Code.put(fpc.getCount() + vc.getCount());

	}

	public void visit(MethodDecls md) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	public void visit(ReturnsExpr re) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	public void visit(ReturnsVoid rv) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	public void visit(Type type) {
		if (type.struct == Tab.intType) {
			typeInt = true;
		} else {
			typeInt = false;
		}
	}

	// =================================STATEMENTS==================================

	public void visit(PrintStatement ps) {
		if (nums.size() > 0) {
			for (int i = 0; i < nums.size(); i++) {
				Code.put(Code.pop);
			}
			if (ps.getExpr().struct.getKind() == Struct.Int) {
				Code.loadConst(4);
				Code.put(Code.print);
			} else if (ps.getExpr().struct.getKind() == Struct.Char) {
				Code.loadConst(1);
				Code.put(Code.bprint);
			} else if (ps.getExpr().struct.getKind() == Struct.Bool) {
				Code.put(Code.pop);
				if (printTrue) {
					Code.loadConst('t');
					Code.loadConst(1);
					Code.put(Code.bprint);
					Code.loadConst('r');
					Code.loadConst(1);
					Code.put(Code.bprint);
					Code.loadConst('u');
					Code.loadConst(1);
					Code.put(Code.bprint);
					Code.loadConst('e');
					Code.loadConst(1);
					Code.put(Code.bprint);
				} else {
					Code.loadConst('f');
					Code.loadConst(1);
					Code.put(Code.bprint);
					Code.loadConst('a');
					Code.loadConst(1);
					Code.put(Code.bprint);
					Code.loadConst('l');
					Code.loadConst(1);
					Code.put(Code.bprint);
					Code.loadConst('s');
					Code.loadConst(1);
					Code.put(Code.bprint);
					Code.loadConst('e');
					Code.loadConst(1);
					Code.put(Code.bprint);
				}
			}
			for (int i = 0; i < nums.size(); i++) {
				Code.loadConst(nums.get(i));
				Code.loadConst(5);
				Code.put(Code.print);
			}

		} else {
			if (ps.getExpr().struct.getKind() == Struct.Int) {
				Code.loadConst(4);
				Code.put(Code.print);
			} else if (ps.getExpr().struct.getKind() == Struct.Char) {
				Code.loadConst(1);
				Code.put(Code.bprint);
			} else if (ps.getExpr().struct.getKind() == Struct.Bool) {
				Code.put(Code.pop);
				if (printTrue) {
					Code.loadConst('t');
					Code.loadConst(1);
					Code.put(Code.bprint);
					Code.loadConst('r');
					Code.loadConst(1);
					Code.put(Code.bprint);
					Code.loadConst('u');
					Code.loadConst(1);
					Code.put(Code.bprint);
					Code.loadConst('e');
					Code.loadConst(1);
					Code.put(Code.bprint);
				} else {
					Code.loadConst('f');
					Code.loadConst(1);
					Code.put(Code.bprint);
					Code.loadConst('a');
					Code.loadConst(1);
					Code.put(Code.bprint);
					Code.loadConst('l');
					Code.loadConst(1);
					Code.put(Code.bprint);
					Code.loadConst('s');
					Code.loadConst(1);
					Code.put(Code.bprint);
					Code.loadConst('e');
					Code.loadConst(1);
					Code.put(Code.bprint);
				}
			}
		}
		nums.clear();
	}

	public void visit(ReadStatement rs) {
		int kind = rs.getDesignator().obj.getType().getKind();

		if (kind == Struct.Char) {
			Code.put(Code.bread);
		}
		else {
			Code.put(Code.read);
		}

		Code.store(rs.getDesignator().obj);
	}

	// ==================================FACTORS====================================

	public void visit(FactorNumber fn) {
		Obj num = Tab.insert(Obj.Con, "$", fn.struct);
		num.setLevel(0);
		num.setAdr(fn.getN1());

		Code.load(num);
	}

	public void visit(FactorChar fc) {
		Obj ch = Tab.insert(Obj.Con, "$", fc.struct);
		ch.setLevel(0);
		ch.setAdr(fc.getC1());

		Code.load(ch);
	}

	public void visit(FactorBool fb) {
		Obj bo = Tab.insert(Obj.Con, "$", fb.struct);
		bo.setLevel(0);
		if (fb.getB1().equals("true")) {
			bo.setAdr(1);
			printTrue = true;
		} else {
			bo.setAdr(0);
			printTrue = false;
		}
		Code.load(bo);
	}

	public void visit(ConstBool b) {
		if (b.getBool().equals("true")) {
			printTrue = true;
		} else {
			printTrue = false;
		}
	}
	
	public void visit(FactorDesignator fd) {
//		Code.load(fd.getDesignator().obj);
	}

	public void visit(FactorNew fn) {
		Code.put(Code.newarray);
		if (typeInt) {
			Code.put(1);
		} else {
			Code.put(0);
		}
	}

	public void visit(MoreNumbers mn) {
		Obj num = Tab.insert(Obj.Con, "$", mn.struct);
		num.setLevel(0);
		num.setAdr(mn.getN());

		nums.add(mn.getN());
		Code.load(num);
	}

	// ===================================TERMS=====================================

	public void visit(MultipleFactors mf) {
		if (mf.getMulop() instanceof Mul) {
			Code.put(Code.mul);
		} else if (mf.getMulop() instanceof Div) {
			Code.put(Code.div);
		} else if (mf.getMulop() instanceof Mod) {
			Code.put(Code.rem);
		}
	}

	public void visit(MultipleTerms mt) {
		if (mt.getAddop() instanceof Add) {
			Code.put(Code.add);
		} else if (mt.getAddop() instanceof Sub) {
			Code.put(Code.sub);
		}
	}

	public void visit(TermOne to) {
		SyntaxNode node = to.getParent();
		while (node != null) {
			if (node.getClass() == NoMinusExpr.class) {
				return;
			}
			if (node.getClass() == MinusExpr.class) {
				Code.put(Code.neg);
				return;
			}
			node = node.getParent();
		}
	}

	// ===========================DESIGNATOR STATEMENTS=============================

	public void visit(DesignatorAssign da) {
		Code.store(da.getDesignator().obj);
	}

	public void visit(DesignatorName dn) {
		if (dn.getParent() instanceof Designator) {
			if (((Designator) dn.getParent()).getParent().getClass() == DesignatorNL.class) {

			} else if ((((Designator) dn.getParent()).getParent().getClass() != DesignatorAssign.class)
					&& ((Designator) dn.getParent()).getParent().getClass() != SingleDesignators.class) {
				Code.load(dn.obj);
			} else if ((((Designator) dn.getParent()).getParent().getClass() == DesignatorAssign.class)
					&& (dn.getParent().getClass() == ArrayElemDesignator.class)
					&& dn.obj.getType().getKind() == Struct.Array) {
				Code.load(dn.obj);
			} else if ((((Designator) dn.getParent()).getParent().getClass() == SingleDesignators.class)
					&& dn.obj.getType().getKind() == Struct.Array) {
				Code.load(dn.obj);
			}
		} else if (dn.getParent() instanceof ArrayDesignator) {

		}
	}

	public void visit(DesignatorInc di) {
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(di.getDesignator().obj);
	}

	public void visit(DesignatorDec dd) {
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(dd.getDesignator().obj);
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

	public void visit(DesignatorArray da) {
		if (designatorArray == null) {
			for (int i = designatorsRight.size() - 1; i >= 0; i--) {
//				Code.store(designatorsRight.get(i));
			}
			for (int i = designatorsLeft.size() - 1; i >= 0; i--) {
				if (designatorsLeft.get(i) == Tab.noObj) {
					continue;
				}
				if (designatorsRight.size() - 1 < i) {
					Code.put(Code.trap);
					Code.put(1);
					break;
				}
				Code.load(designatorsRight.get(i));

				Code.store(designatorsLeft.get(i));
			}

		} else {
			for (int i = designatorsLeft.size() - 1; i >= 0; i--) {
				if (designatorsLeft.get(i) == Tab.noObj) {
					continue;
				}
//				Code.store(designatorsLeft.get(i));
			}
			Code.load(designatorArray);
			Code.put(Code.arraylength);
			Code.loadConst(designatorsLeft.size());
			Code.putFalseJump(Code.lt, Code.pc + 5);
			Code.put(Code.trap);
			Code.put(2);

			for (int i = designatorsLeft.size() - 1; i >= 0; i--) {
//				Code.load(designatorsLeft.get(i));
				if (designatorsLeft.get(i) == Tab.noObj) {
					continue;
				}
				Code.load(designatorArray);
				Code.loadConst(i);
				Code.put(Code.aload);

				Code.store(designatorsLeft.get(i));
			}
		}

		designatorsLeft = null;
		designatorsRight = null;
		designatorArray = null;
	}

	// ================================DESIGNATORS==================================

	public void visit(ArrayElemDesignator aed) {
		if (aed.obj.getType().getKind() == Struct.Char) {
			if (aed.getParent().getClass() == FactorDesignator.class) {
				Code.put(Code.baload);
			} else if (aed.getParent().getClass() == DesignatorDec.class
					|| aed.getParent().getClass() == DesignatorInc.class) {
				Code.put(Code.dup2);
				Code.put(Code.baload);
			}
		} else {
			if (aed.getParent().getClass() == FactorDesignator.class) {
				Code.put(Code.aload);
			} else if (aed.getParent().getClass() == DesignatorDec.class
					|| aed.getParent().getClass() == DesignatorInc.class) {
				Code.put(Code.dup2);
				Code.put(Code.aload);
			}
		}
	}

	public void visit(SingleDesignator sd) {
		if (sd.getParent().getClass() == ReadStatement.class) {
			Code.put(Code.pop);
		}
	}

}
