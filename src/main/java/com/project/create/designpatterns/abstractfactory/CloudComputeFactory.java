package com.project.create.designpatterns.abstractfactory;

public abstract class CloudComputeFactory {

    public static CloudComputeFactory getCloudComouteFactory(CloudComputeType cloudComputeType){

        switch (cloudComputeType){
            case AWS:
                return new AWSFactory();
            case AZURE:
                return new AzureFactory();
        }
        return null;
    }

    public abstract CloudInstance getCloudInstance(InstanceType instanceType);
}
