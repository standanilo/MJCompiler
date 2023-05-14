// generated with ast extension for cup
// version 0.8
// 17/0/2023 17:36:42


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(Unmatched Unmatched);
    public void visit(Operation Operation);
    public void visit(MethodDecl MethodDecl);
    public void visit(Mulop Mulop);
    public void visit(VarDeclaration VarDeclaration);
    public void visit(ClassBodyDecl ClassBodyDecl);
    public void visit(Matched Matched);
    public void visit(DesignatorN DesignatorN);
    public void visit(Relop Relop);
    public void visit(MulopFactorList MulopFactorList);
    public void visit(CondTermList CondTermList);
    public void visit(ProgDeclList ProgDeclList);
    public void visit(RExpr RExpr);
    public void visit(StatementList StatementList);
    public void visit(Addop Addop);
    public void visit(Factor Factor);
    public void visit(CondTerm CondTerm);
    public void visit(DesignatorLST DesignatorLST);
    public void visit(GlobalVarDeclSemi GlobalVarDeclSemi);
    public void visit(GlobalVarDecl GlobalVarDecl);
    public void visit(Designator Designator);
    public void visit(ClassVarDeclList ClassVarDeclList);
    public void visit(ProgDecl ProgDecl);
    public void visit(FormParsList FormParsList);
    public void visit(ConstDeclList ConstDeclList);
    public void visit(ActParsList ActParsList);
    public void visit(ConstDeclaration ConstDeclaration);
    public void visit(GlobalVarDeclComma GlobalVarDeclComma);
    public void visit(FormParDecl FormParDecl);
    public void visit(GlobalVarDeclaration GlobalVarDeclaration);
    public void visit(VarDeclList VarDeclList);
    public void visit(Expr Expr);
    public void visit(DesignatorLS DesignatorLS);
    public void visit(DesignatorList DesignatorList);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(MethodReturnType MethodReturnType);
    public void visit(ClassDeclList ClassDeclList);
    public void visit(ActParsListNB ActParsListNB);
    public void visit(Statement Statement);
    public void visit(VarDecl VarDecl);
    public void visit(Numbers Numbers);
    public void visit(ExprOrActPars ExprOrActPars);
    public void visit(ConstDecl ConstDecl);
    public void visit(CondFact CondFact);
    public void visit(ClassExtendDecl ClassExtendDecl);
    public void visit(MethodVarDeclList MethodVarDeclList);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(ActParsListN ActParsListN);
    public void visit(FormPars FormPars);
    public void visit(GlobalVarDeclList GlobalVarDeclList);
    public void visit(ClassMethodDecl ClassMethodDecl);
    public void visit(AddopTermList AddopTermList);
    public void visit(Mod Mod);
    public void visit(Div Div);
    public void visit(Mul Mul);
    public void visit(Sub Sub);
    public void visit(Add Add);
    public void visit(RelopLeq RelopLeq);
    public void visit(RelopLt RelopLt);
    public void visit(RelopGeq RelopGeq);
    public void visit(RelopGt RelopGt);
    public void visit(RelopNeq RelopNeq);
    public void visit(RelopEq RelopEq);
    public void visit(Assignop Assignop);
    public void visit(Label Label);
    public void visit(DesignatorName DesignatorName);
    public void visit(SingleDesignator SingleDesignator);
    public void visit(FieldDesignator FieldDesignator);
    public void visit(ArrayElemDesignator ArrayElemDesignator);
    public void visit(FactorNewActPars FactorNewActPars);
    public void visit(FactorNewExpr FactorNewExpr);
    public void visit(NoBracesPars NoBracesPars);
    public void visit(BracesPars BracesPars);
    public void visit(FactorExpr FactorExpr);
    public void visit(FactorNew FactorNew);
    public void visit(FactorBool FactorBool);
    public void visit(FactorChar FactorChar);
    public void visit(FactorNumber FactorNumber);
    public void visit(FactorDesignator FactorDesignator);
    public void visit(FactorOne FactorOne);
    public void visit(MultipleFactors MultipleFactors);
    public void visit(Term Term);
    public void visit(TermOne TermOne);
    public void visit(MultipleTerms MultipleTerms);
    public void visit(NoMinusExpr NoMinusExpr);
    public void visit(MinusExpr MinusExpr);
    public void visit(CompareExpression CompareExpression);
    public void visit(OneExpression OneExpression);
    public void visit(SignleConditionFact SignleConditionFact);
    public void visit(MultipleConditionFacts MultipleConditionFacts);
    public void visit(SignelConditionOr SignelConditionOr);
    public void visit(MultipleConditionsOr MultipleConditionsOr);
    public void visit(Condition Condition);
    public void visit(ActPars ActPars);
    public void visit(SingleActPars SingleActPars);
    public void visit(MultipleActPars MultipleActPars);
    public void visit(NoActPars NoActPars);
    public void visit(SomeActPars SomeActPars);
    public void visit(RBracket RBracket);
    public void visit(LBracket LBracket);
    public void visit(DesignatorDec DesignatorDec);
    public void visit(DesignatorInc DesignatorInc);
    public void visit(DesignatorActPars DesignatorActPars);
    public void visit(DesignatorError3 DesignatorError3);
    public void visit(DesignatorAssign DesignatorAssign);
    public void visit(NoDesignators NoDesignators);
    public void visit(SingleDesignators SingleDesignators);
    public void visit(SingleDesignatorN SingleDesignatorN);
    public void visit(MultipleDesignators MultipleDesignators);
    public void visit(DesignatorNL DesignatorNL);
    public void visit(SingleDesignatorsLST SingleDesignatorsLST);
    public void visit(MultipleDesignatorsLST MultipleDesignatorsLST);
    public void visit(ArrayDesignator ArrayDesignator);
    public void visit(BracketsDesignators BracketsDesignators);
    public void visit(RBracketD2 RBracketD2);
    public void visit(LBracketD2 LBracketD2);
    public void visit(RBracketD1 RBracketD1);
    public void visit(LBracketD1 LBracketD1);
    public void visit(DesignatorError DesignatorError);
    public void visit(DesignatorArray DesignatorArray);
    public void visit(DesignatorOperation DesignatorOperation);
    public void visit(NoNumbers NoNumbers);
    public void visit(MoreNumbers MoreNumbers);
    public void visit(ReturnsVoid ReturnsVoid);
    public void visit(ReturnsExpr ReturnsExpr);
    public void visit(MultipleStatements MultipleStatements);
    public void visit(PrintStatement PrintStatement);
    public void visit(ReadStatement ReadStatement);
    public void visit(ReturnStatement ReturnStatement);
    public void visit(ContinueStatement ContinueStatement);
    public void visit(BreakStatement BreakStatement);
    public void visit(MatchedIfElseStatement MatchedIfElseStatement);
    public void visit(DesignatorStatements DesignatorStatements);
    public void visit(UnmatchedIfElseStatement UnmatchedIfElseStatement);
    public void visit(UnmatchedIfStatement UnmatchedIfStatement);
    public void visit(WhileStatement WhileStatement);
    public void visit(UnmatchedStatement UnmatchedStatement);
    public void visit(MatchedStatement MatchedStatement);
    public void visit(NoStmt NoStmt);
    public void visit(Statements Statements);
    public void visit(Type Type);
    public void visit(NoMethodVarDeclarations NoMethodVarDeclarations);
    public void visit(MethodVarDeclarations MethodVarDeclarations);
    public void visit(FormalParamArray FormalParamArray);
    public void visit(FormalParam FormalParam);
    public void visit(SingleParamsDeclaration SingleParamsDeclaration);
    public void visit(MultipleParamsDeclarations MultipleParamsDeclarations);
    public void visit(NoParamsDeclarations NoParamsDeclarations);
    public void visit(ParamsDeclarations ParamsDeclarations);
    public void visit(ReturnVoid ReturnVoid);
    public void visit(ReturnType ReturnType);
    public void visit(MethodDecls MethodDecls);
    public void visit(NoneMethodDeclarations NoneMethodDeclarations);
    public void visit(MultipleMethodDeclarations MultipleMethodDeclarations);
    public void visit(ClassMethods ClassMethods);
    public void visit(NoClassBody NoClassBody);
    public void visit(ClassBodyDeclarations ClassBodyDeclarations);
    public void visit(NoClassVarDeclarations NoClassVarDeclarations);
    public void visit(ClassVarDeclarations ClassVarDeclarations);
    public void visit(NoClassExtend NoClassExtend);
    public void visit(ClassExtend ClassExtend);
    public void visit(ClassName ClassName);
    public void visit(ClassDeclarations ClassDeclarations);
    public void visit(ArrayVarDeclarations ArrayVarDeclarations);
    public void visit(NoArrayVarDeclarations NoArrayVarDeclarations);
    public void visit(SingleVarDeclaration SingleVarDeclaration);
    public void visit(MultipleVarDeclarations MultipleVarDeclarations);
    public void visit(VarDeclarations VarDeclarations);
    public void visit(ArrayGlobalVarDeclarations ArrayGlobalVarDeclarations);
    public void visit(NoArrayGlobalVarDeclarations NoArrayGlobalVarDeclarations);
    public void visit(GlobalVarDeclarationError2 GlobalVarDeclarationError2);
    public void visit(GlobalVarSemi GlobalVarSemi);
    public void visit(GlobalVarDeclarationError1 GlobalVarDeclarationError1);
    public void visit(GlobalVarComma GlobalVarComma);
    public void visit(SingleGlobalVarDeclaration SingleGlobalVarDeclaration);
    public void visit(MultipleGlobalVarDeclarations MultipleGlobalVarDeclarations);
    public void visit(GlobalVarDeclarations GlobalVarDeclarations);
    public void visit(ConstChar ConstChar);
    public void visit(ConstBool ConstBool);
    public void visit(ConstNumber ConstNumber);
    public void visit(SingleConstDeclaration SingleConstDeclaration);
    public void visit(MultipleConstDeclarations MultipleConstDeclarations);
    public void visit(ConstDeclarations ConstDeclarations);
    public void visit(ProgClassList ProgClassList);
    public void visit(ProgVarList ProgVarList);
    public void visit(ProgConstList ProgConstList);
    public void visit(NoProgDeclarations NoProgDeclarations);
    public void visit(ProgDeclarations ProgDeclarations);
    public void visit(ProgName ProgName);
    public void visit(Program Program);

}
