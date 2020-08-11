package com.eyelockgames.designpatterns.creational.factory;

public class FactoryDP {

    //Abstract Factory
    class Client {
        private Factory factory;
        public Client (Factory factory) {
            this.factory = factory;
        }
        public void anOperation() {
            ProductA p = factory.createProductA();
            p.doSomething();//other products and operations as well
        }
    }
    interface Factory {
        ProductA createProductA();
        ProductB createProductB();
    }
    //concrete factories also, implementing Factory interface

}
