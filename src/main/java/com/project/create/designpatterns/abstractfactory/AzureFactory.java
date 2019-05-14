package com.project.create.designpatterns.abstractfactory;

public class AzureFactory extends CloudComputeFactory {

    @Override
    public CloudInstance getCloudInstance(InstanceType instanceType) {

        switch (instanceType){
            case DB:
                return new AzureDBInstance();
            case OS:
                return new AzureOSInstance();
        }

        return null;
    }

}
