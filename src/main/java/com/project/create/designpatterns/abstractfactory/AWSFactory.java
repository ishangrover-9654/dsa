package com.project.create.designpatterns.abstractfactory;

public class AWSFactory extends CloudComputeFactory{
    @Override
    public CloudInstance getCloudInstance(InstanceType instanceType) {

        switch (instanceType){
            case DB:
                return new AWSDBInstance();
            case OS:
                return new AWSOSInstance();
        }

        return null;
    }
}
