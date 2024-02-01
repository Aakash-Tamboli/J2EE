
1)---------------------------Start-------------------------
Object.keys(pass_your_json_object) it will returns an array containg all properties names.
Object.value(pass_your_json_object) it will returns you know. all values against properties.

Draw Back of above methods that it is not gurrented that both array contains same order of thier respective key-value properties.

When Requirement is we want key and value both repectively then
following trick will work.

for(let key in queryStringData)
{
url=url+key+"="+queryStringData[key];
}
1)----------------------------End-----------------------
2)----------------------------Start---------------------

(html tag)domObject.hasAttribute('attributeName') -
	it returns true if attributeName is applied on domObj(html tag)
	otherwise it return false
(html tag)domObject.getAttribute('attributeName') -
	it returns value of corrsesponding attributeName which is applied on domObj(html tag)

2)----------------------------End-----------------------




