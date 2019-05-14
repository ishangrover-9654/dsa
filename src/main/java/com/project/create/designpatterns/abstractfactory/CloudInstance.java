package com.project.create.designpatterns.abstractfactory;

public interface CloudInstance {

    public void createInstance();
    public void stopInstance();
    public void startInstance();
    public void terminateInstance();

}
