package se.kth.iv1350.sellProcess.integration.DTO;

import se.kth.iv1350.sellProcess.model.DiscountFactoryEnum;

public class DiscountRulesDTO {

     private String identitfier;
     private double discountInCash;
     private double discountPercentage;
     private DiscountFactoryEnum type;
     private int bigBuyDiscount;
     

    public DiscountRulesDTO(String itemID, double discountInCash, double discountPercentage, DiscountFactoryEnum discountType, int totalSumToGetDiscount
    ) {

        this.identitfier = itemID;
        this.discountInCash = discountInCash;
        this.discountPercentage = discountPercentage;
        this.type = discountType;
        this.bigBuyDiscount = totalSumToGetDiscount;
    }

    public String getIdentitfier(){

        return identitfier;
    }

    public double getDiscountInCash(){

        return discountInCash;
    }

     public double getDiscountPercentage(){

        return discountPercentage;
    }


     public DiscountFactoryEnum getEnum(){

        return type;
    }  

    public int getBigBuyDiscount(){
        return bigBuyDiscount;
    }
}
