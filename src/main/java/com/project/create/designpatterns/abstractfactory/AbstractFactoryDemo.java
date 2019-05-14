package com.project.create.designpatterns.abstractfactory;

public class AbstractFactoryDemo {

    public static void main(String[] args) {
        CloudComputeFactory cloudComputeAWSFactory = CloudComputeFactory.getCloudComouteFactory(CloudComputeType.AWS);

        CloudInstance cloudawsInstance =  cloudComputeAWSFactory.getCloudInstance(InstanceType.OS);

        cloudawsInstance.createInstance();


        CloudComputeFactory cloudComputAzureFactory = CloudComputeFactory.getCloudComouteFactory(CloudComputeType.AWS);

        CloudInstance cloudAzureInstance =  cloudComputAzureFactory.getCloudInstance(InstanceType.OS);

        cloudAzureInstance.createInstance();


    }

}
