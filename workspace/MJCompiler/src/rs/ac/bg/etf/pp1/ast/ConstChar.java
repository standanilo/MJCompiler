// generated with ast extension for cup
// version 0.8
// 17/0/2023 17:36:42


package rs.ac.bg.etf.pp1.ast;

public class ConstChar extends ConstDecl {

    private String characters;
    private Character c;

    public ConstChar (String characters, Character c) {
        this.characters=characters;
        this.c=c;
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters=characters;
    }

    public Character getC() {
        return c;
    }

    public void setC(Character c) {
        this.c=c;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstChar(\n");

        buffer.append(" "+tab+characters);
        buffer.append("\n");

        buffer.append(" "+tab+c);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstChar]");
        return buffer.toString();
    }
}
