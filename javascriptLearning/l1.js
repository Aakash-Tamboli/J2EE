/*
Example of calling method which required passing args,
But We can call withour passing args,
hence it is feature,
And Remeber In javascript null is treated as Object.
*/

function SomeClass(){
  this.someProperty=function(someParameter){
    console.log(someParameter);
    console.log("Hi");
  }
}

let someObj=new SomeClass();
someObj.someProperty();
someObj.someProperty("Aakash");
