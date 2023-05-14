// generated with ast extension for cup
// version 0.8
// 17/0/2023 17:36:42


package rs.ac.bg.etf.pp1.ast;

public class ClassBodyDeclarations extends ClassBodyDecl {

    private ClassMethodDecl ClassMethodDecl;

    public ClassBodyDeclarations (ClassMethodDecl ClassMethodDecl) {
        this.ClassMethodDecl=ClassMethodDecl;
        if(ClassMethodDecl!=null) ClassMethodDecl.setParent(this);
    }

    public ClassMethodDecl getClassMethodDecl() {
        return ClassMethodDecl;
    }

    public void setClassMethodDecl(ClassMethodDecl ClassMethodDecl) {
        this.ClassMethodDecl=ClassMethodDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ClassMethodDecl!=null) ClassMethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassMethodDecl!=null) ClassMethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassMethodDecl!=null) ClassMethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassBodyDeclarations(\n");

        if(ClassMethodDecl!=null)
            buffer.append(ClassMethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassBodyDeclarations]");
        return buffer.toString();
    }
}
