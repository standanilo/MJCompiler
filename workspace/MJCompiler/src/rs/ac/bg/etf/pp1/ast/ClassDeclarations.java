// generated with ast extension for cup
// version 0.8
// 17/0/2023 17:36:42


package rs.ac.bg.etf.pp1.ast;

public class ClassDeclarations extends ClassDeclList {

    private ClassName ClassName;
    private ClassExtendDecl ClassExtendDecl;
    private ClassVarDeclList ClassVarDeclList;
    private ClassBodyDecl ClassBodyDecl;

    public ClassDeclarations (ClassName ClassName, ClassExtendDecl ClassExtendDecl, ClassVarDeclList ClassVarDeclList, ClassBodyDecl ClassBodyDecl) {
        this.ClassName=ClassName;
        if(ClassName!=null) ClassName.setParent(this);
        this.ClassExtendDecl=ClassExtendDecl;
        if(ClassExtendDecl!=null) ClassExtendDecl.setParent(this);
        this.ClassVarDeclList=ClassVarDeclList;
        if(ClassVarDeclList!=null) ClassVarDeclList.setParent(this);
        this.ClassBodyDecl=ClassBodyDecl;
        if(ClassBodyDecl!=null) ClassBodyDecl.setParent(this);
    }

    public ClassName getClassName() {
        return ClassName;
    }

    public void setClassName(ClassName ClassName) {
        this.ClassName=ClassName;
    }

    public ClassExtendDecl getClassExtendDecl() {
        return ClassExtendDecl;
    }

    public void setClassExtendDecl(ClassExtendDecl ClassExtendDecl) {
        this.ClassExtendDecl=ClassExtendDecl;
    }

    public ClassVarDeclList getClassVarDeclList() {
        return ClassVarDeclList;
    }

    public void setClassVarDeclList(ClassVarDeclList ClassVarDeclList) {
        this.ClassVarDeclList=ClassVarDeclList;
    }

    public ClassBodyDecl getClassBodyDecl() {
        return ClassBodyDecl;
    }

    public void setClassBodyDecl(ClassBodyDecl ClassBodyDecl) {
        this.ClassBodyDecl=ClassBodyDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ClassName!=null) ClassName.accept(visitor);
        if(ClassExtendDecl!=null) ClassExtendDecl.accept(visitor);
        if(ClassVarDeclList!=null) ClassVarDeclList.accept(visitor);
        if(ClassBodyDecl!=null) ClassBodyDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassName!=null) ClassName.traverseTopDown(visitor);
        if(ClassExtendDecl!=null) ClassExtendDecl.traverseTopDown(visitor);
        if(ClassVarDeclList!=null) ClassVarDeclList.traverseTopDown(visitor);
        if(ClassBodyDecl!=null) ClassBodyDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassName!=null) ClassName.traverseBottomUp(visitor);
        if(ClassExtendDecl!=null) ClassExtendDecl.traverseBottomUp(visitor);
        if(ClassVarDeclList!=null) ClassVarDeclList.traverseBottomUp(visitor);
        if(ClassBodyDecl!=null) ClassBodyDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDeclarations(\n");

        if(ClassName!=null)
            buffer.append(ClassName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassExtendDecl!=null)
            buffer.append(ClassExtendDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassVarDeclList!=null)
            buffer.append(ClassVarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassBodyDecl!=null)
            buffer.append(ClassBodyDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDeclarations]");
        return buffer.toString();
    }
}
