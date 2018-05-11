var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){

	if (n < 0)
		return -1;
	else if (n == 0)
		return 0;
	else if (n==1)
		return 1;
	
	else {return homework.fibonacci(n-1) + homework.fibonacci(n-2);}
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
	//lets try bubble sort 1st
	var temp = 0;
	var size = array.length;
	var tempArray = new Array(size);
	
	for(var j = 0; j < size; j++){
		for(var i = 0; i < size; i++){
		
			if(array[i] > array[i+1]){
				temp = array[i+1];
				array[i+1] = array[i];
				array[i] = temp;
			}
		
		}
	}
	
	return array.toString();
};

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){

	if (n==0){
		return 1;
	}
	if (n==1){
		return 1;
	}
	else{
		var temp = 1;
		for(var i = 1; i <= n; i++){
			temp = temp * i;
		}
		return temp;
	}

};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
	
	var temp = 0;
	var size = array.length;
	var tempArray = new Array(size);
	tempArray[0] = array[0];
	
	for(var i = 0; i < n; i++){
		temp = array[0];
		for(var j = 1; j < size; j++){
			array[j-1] = array[j];
			
		}
		array[size-1]=temp;
	}
	return array.toString();
};

/*
 5. Balanced Brackets

 A bracket is any one of the following: (, ), {, }, [, or ]

 The following are balanced brackets:
    ()
    ()()
    (())
    ({[]})

 The following are NOT balanced brackets:
 (
 )
 (()
 ([)]

 Return true if balanced
 Return false if not balanced
*/
homework.balancedBrackets = function(bracketsString){
	
	var myStack = new Array(bracketsString.length);
	var counter = 0;
	var peek = myStack[myStack.length-1];
	var opener = 0;
	
	
	for(var i = 0; i < bracketsString.length; i++){
		if(bracketsString[i] == ("(")){
			myStack.push("(");
			counter++;
			opener++;
			peek = myStack[myStack.length-1];
			console.log( "found a (" + "counter: " +counter);
		}
		if(bracketsString[i] == ("[")){
			myStack.push("[");
			counter++;
			opener++;
			peek = myStack[myStack.length-1];
			console.log( "found a [" + "counter: " +counter);
		}
		if(bracketsString[i] == ("{")){
			myStack.push("{");
			counter++;
			opener++;
			peek = myStack[myStack.length-1];
			console.log( "found a {" + "counter: " +counter);
		}
		if(bracketsString[i] == (")")){
			console.log("peek: "+peek);
			if(peek =="("){
				console.log("found opening(");
				myStack.pop();
				peek = myStack[myStack.length-1];
				opener--;
				counter++;}
			else{
				counter++;
				console.log("error: no ( found");	
				return false;
			}	
		}
		if(bracketsString[i] == ("]")){
			console.log("peek: "+peek);
			if(peek =="["){
				console.log("found opening[");
				myStack.pop();
				peek = myStack[myStack.length-1];
				opener--;
				counter++;}
			else{
				counter++;
				console.log("error: no [ found");	
				return false;
			}	
		}
		if(bracketsString[i] == ("}")){
			console.log("peek: "+peek);
			if(peek =="{"){
				console.log("found opening{");
				myStack.pop();
				peek = myStack[myStack.length-1];
				opener--;
				counter++;}
			else{
				counter++;
				console.log("error: no { found");	
				return false;
			}	
		}
		//else{return false;}
		
	}
	if(opener > 0){return false;}
	return true;
};


YOUR SOLUTIONS, NOT STACKOVERFLOW’S  ;)

