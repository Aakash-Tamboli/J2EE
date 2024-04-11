let accordian=document.getElementById("mymy");
let children=accordian.childNodes;
let i;
for(i=0;i<children.length;i++)
{
    console.log(children[i].nodeName); // here you noticed #text props appear
}


