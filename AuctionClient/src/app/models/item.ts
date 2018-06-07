import { User } from "../user";


export class Item {
    id: number;
    itemName: string;
    timeLimit: string;
    categoryTag: string;
    sellerId: User;/*
    image: string;
    currentPrice: number;
   
    buyerId: User;*/

    constructor(
        id: number,
        itemName: string,
        timeLimit: string,
        categoryTag: string,
        sellerId: User,/*
        image: string,
        currentPrice: number,
       
        buyerId: User,*/
    ) {

        this.id=id;
        this.itemName = itemName;
        this.timeLimit=timeLimit;
        this.categoryTag=categoryTag;
        this.sellerId=sellerId;/*
        this.image=image;
        this.currentPrice=currentPrice;
        this.sellerId=sellerId;
        this.buyerId=buyerId;*/

    }

}


