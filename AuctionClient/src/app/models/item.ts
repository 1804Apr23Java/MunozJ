import { User } from "../user";


export class Item {

    itemName: string;
    description: string;
    currentPrice: number;
    categoryTag: string;
    image: string;
    timeLeft: number;
    id: number;



    /*
    sellerId: User;
       //  ///add/{itemName}/{description}/{currentPrice}/{categoryTag}/{image}/{timeLeft}
    id: number;
     buyerId: User;*/

    constructor(

        itemName: string,
        description: string,
        currentPrice: number,
        categoryTag: string,
        image: string,
        timeLeft: number,
        id: number,
        /*
              id: number,
       
       sellerId: User,
        buyerId: User,*/
    ) {


        this.itemName = itemName;
        this.timeLeft = timeLeft;
        this.categoryTag = categoryTag;
        this.image = image;
        this.description = description;
        this.currentPrice = currentPrice;
        this.id=id;
        /*
          this.id=id;
        this.sellerId=sellerId;
      
        this.sellerId=sellerId;
        this.buyerId=buyerId;*/

    }

}


