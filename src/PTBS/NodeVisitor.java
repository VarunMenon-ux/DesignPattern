package PTBS;

abstract public class NodeVisitor {
    abstract public void visitProduct(Product product);
    abstract public void visitTrading(Trading trading);
    abstract public void visitFacade(Facade facade);
}
