function initialdelay() {
	setTimeout("bringin()",300);
}

function setobj() {
 obj1=document.getElementById('div1');
 obj2=document.getElementById('div2');
 obj3=document.getElementById('div3');
 obj4=document.getElementById('div4');
 obj5=document.getElementById('div5');
 obj6=document.getElementById('div6');
 obj7=document.getElementById('div7');
 obj8=document.getElementById('div8');
}


function bringin() {
	setobj();	
		if(val1<=width1)
	{		
		add1=(width1-val1)/42;
		add2=(width2-val2)/42;
		if(add1>0.042){
			val1+=add1;
			val2+=add2;
			obj1.style.left=val1;
			obj2.style.left=val2;
			obj3.style.left=val1;
			obj4.style.left=val2;
			setTimeout(function() { bringin() },1);
		}
		else { 	
			val1-=add1*24;
			val2-=add2*24;	
			setTimeout(function() {obj1.style.left=val1;
					       obj2.style.left=val2;
					       obj3.style.left=val1;
					       obj4.style.left=val2;	       
					       val3=val1;
					       val4=val2;
					       val1=0;
					       val2=0;
					       if(results[count+1])
						       document.getElementById('right').style.visibility='visible'},1);
		}
	}

}
	function takeoutright(visible,hidden) {
		setobj();
		if(previous=='right' && movecount) {
			if(hidden=='group2') 
				setdata('group2','right');
			else 
				setdata('group1','right');
		}

		if(hidden=='group2') {				
			obj5.style.visibility='visible';
			obj6.style.visibility='visible';
			obj7.style.visibility='visible';
			obj8.style.visibility='visible';
		}
		else {
			obj1.style.visibility='visible';
			obj2.style.visibility='visible';
			obj3.style.visibility='visible';
			obj4.style.visibility='visible';
		}

	if(val3<=width && val1<=width1)
	{
		val3+=23;
		val4+=43;
		add1=(width1-val1)/42;
		val1+=add1;
		add2=(width2-val2)/42;
		val2+=add2;
		if(hidden=='group2') {
			obj1.style.left=val3;
			obj2.style.left=val4;
			obj3.style.left=val3;
			obj4.style.left=val4;
			obj5.style.left=val1;
			obj6.style.left=val2;
			obj7.style.left=val1;
			obj8.style.left=val2;

		}
		else {
			obj1.style.left=val1;
			obj2.style.left=val2;
			obj3.style.left=val1;
			obj4.style.left=val2;
			obj5.style.left=val3;
			obj6.style.left=val4;
			obj7.style.left=val3;
			obj8.style.left=val4;
		}
		setTimeout(function() {takeoutright(visible,hidden) },1);
	}
	else if(val4<=width && val1<=width) {
		if(hidden=='group2') {
			obj1.style.visibility='hidden';
			obj3.style.visibility='hidden';
		}
		else {
			obj5.style.visibility='hidden';
			obj7.style.visibility='hidden';
		}
		val4+=43;	
		add1=(width1-val1)/42;
		add2=(width2-val2)/42;
		val1+=add1;
		val2+=add2;
		if(hidden=='group2') {
			obj2.style.left=val4;
			obj4.style.left=val4;
			obj5.style.left=val1;
			obj6.style.left=val2;
			obj7.style.left=val1;
			obj8.style.left=val2;
		}
		else {
			obj1.style.left=val1;
			obj2.style.left=val2;
			obj3.style.left=val1;
			obj4.style.left=val2;
			obj6.style.left=val4;
			obj8.style.left=val4;
		}
		setTimeout(function() {takeoutright(visible,hidden) },1);
	}
	else {
		if(hidden=='group2') {
			obj2.style.visibility='hidden';
			obj4.style.visibility='hidden';
		}
		else {
			obj6.style.visibility='hidden';
			obj8.style.visibility='hidden';
		}
		add1=(width1-val1)/42;
		add2=(width2-val2)/42;
		if(add1>0.042){
			val1+=add1;
			val2+=add2;
			if(hidden=='group2') {
			obj5.style.left=val1;
			obj6.style.left=val2;
			obj7.style.left=val1;
			obj8.style.left=val2;
			}
			else {
			  obj1.style.left=val1;
			  obj2.style.left=val2;
			  obj3.style.left=val1;
			  obj4.style.left=val2;
			}
			setTimeout(function() { takeoutright(visible,hidden) },1);
		}
		else { 	
			val1-=add1*24;
			val2-=add2*24;	
			setTimeout(function() { 
						if(hidden=='group2') {
							obj5.style.left=val1;
							obj6.style.left=val2;
							obj7.style.left=val1;
							obj8.style.left=val2;
							}
						else {

							obj1.style.left=val1;
							obj2.style.left=val2;
							obj3.style.left=val1;
							obj4.style.left=val2;
						}

						val3=val1;
						val4=val2;
						val1=0;
						val2=0;
						previous='right';
						movecount=true;
						document.getElementById('left').style.visibility='visible'},1);
		}
	}		
}
	function takeoutleft(visible,hidden) {
		setobj();

	       	if(previous=='left' && movecount) {
			if(hidden=='group2')
				setdata('group2','left');
			else 
				setdata('group1','left');
		}
		if(hidden=='group2') {				
			obj5.style.visibility='visible';
			obj6.style.visibility='visible';
			obj7.style.visibility='visible';
			obj8.style.visibility='visible';
		}
		else {
			obj1.style.visibility='visible';
			obj2.style.visibility='visible';
			obj3.style.visibility='visible';
			obj4.style.visibility='visible';
		}

	if(val4>=0 && val1<=width1)
	{
		val4-=23;
		val3-=43;
		add1=(width1-val1)/42;
		val1+=add1;
		add2=(width2-val2)/42;
		val2+=add2;
		if(hidden=='group2') {
			obj1.style.left=val3;
			obj2.style.left=val4;
			obj3.style.left=val3;
			obj4.style.left=val4;
			obj5.style.left=width-val2;
			obj6.style.left=width-val1;
			obj7.style.left=width-val2;
			obj8.style.left=width-val1;

		}
		else {
			obj1.style.left=width-val2;
			obj2.style.left=width-val1;
			obj3.style.left=width-val2;
			obj4.style.left=width-val1;
			obj5.style.left=val3;
			obj6.style.left=val4;
			obj7.style.left=val3;
			obj8.style.left=val4;
		}
		setTimeout(function() {takeoutleft(visible,hidden) },1);
	}
	else if(val3>=0 && val1<=width) {
		if(hidden=='group2') {
			obj2.style.visibility='hidden';
			obj4.style.visibility='hidden';
		}
		else {
			obj6.style.visibility='hidden';
			obj8.style.visibility='hidden';
		}
		val3-=43;	
		add1=(width1-val1)/42;
		add2=(width2-val2)/42;
		val1+=add1;
		val2+=add2;
		if(hidden=='group2') {
			obj1.style.left=val3;
			obj3.style.left=val3;
			obj5.style.left=width-val2;
			obj6.style.left=width-val1;
			obj7.style.left=width-val2;
			obj8.style.left=width-val1;
		}
		else {
			obj1.style.left=width-val2;
			obj2.style.left=width-val1;
			obj3.style.left=width-val2;
			obj4.style.left=width-val1;
			obj5.style.left=val3;
			obj7.style.left=val3;
		}
		setTimeout(function() {takeoutleft(visible,hidden) },1);
	}
	else {
			if(hidden=='group2') {
			obj1.style.visibility='hidden';
			obj3.style.visibility='hidden';
		}
		else {
			obj5.style.visibility='hidden';
			obj7.style.visibility='hidden';
		}
		add1=(width1-val1)/42;
		add2=(width2-val2)/42;
		if(add1>0.042){
			val1+=add1;
			val2+=add2;
			if(hidden=='group2') {
			obj5.style.left=width-val2;
			obj6.style.left=width-val1;
			obj7.style.left=width-val2;
			obj8.style.left=width-val1;
			}
			else {
			  obj1.style.left=width-val2;
			  obj2.style.left=width-val1;
			  obj3.style.left=width-val2;
			  obj4.style.left=width-val1;
			}
			setTimeout(function() { takeoutleft(visible,hidden) },1);
		}
		else { 	
			val1-=add1*24;
			val2-=add2*24;	
			setTimeout(function() { 
						if(hidden=='group2') {
							obj5.style.left=width-val2;
							obj6.style.left=width-val1;
							obj7.style.left=width-val2;
							obj8.style.left=width-val1;
							}
						else {

							obj1.style.left=width-val2;
							obj2.style.left=width-val1;
							obj3.style.left=width-val2;
							obj4.style.left=width-val1;
						}

						val3=width-val2;
						val4=width-val1;
						val1=0;
						val2=0;
						previous='left';
						movecount=true;
						if(count==8)
						document.getElementById('left').style.visibility='hidden'},1);
		}
	}		
}
		
	function setdata(group,direction) {
		movecount=false;
		i=0;
		limit=0;
		if(group=='group2'){ 
				i=5;
				limit=8;
			}
			else { 
				i=1;
				limit=4;
			}

		if(direction=='right') {
			while(results[count] && i<=limit) {
			document.getElementById('a'+i).innerHTML=results[count]['title'];
			document.getElementById('a'+i).href="http://"+results[count]['url'];
			document.getElementById('s'+i).innerHTML=results[count]['snippet'];
			document.getElementById('f'+i).innerHTML=results[count]['url'].split('/')[0];
			count++;
			i++;
		}
                while(i<=limit) {
			document.getElementById('div'+i).style.visibility='hidden';	
			i++;
		}

		if(! results[count])
			document.getElementById('right').style.visibility='hidden';
		}
		//can be written in a shorter way without the else block
	  else {
		  tempcount=count-9;
		  count-=4;
		  while(results[tempcount] && i<=limit) {
			  div=limit-i+1;
		 document.getElementById('a'+div).innerHTML=results[tempcount]['title'];
			document.getElementById('a'+div).href="http://"+results[tempcount]['url'];
			document.getElementById('s'+div).innerHTML=results[tempcount]['snippet'];
			document.getElementById('f'+div).innerHTML=results[tempcount]['url'].split('/')[0];
			tempcount--;
			i++;
		}
                while(i<=limit) {
			document.getElementById('div'+i).style.visibility='hidden';	
			i++;
		}

		if(! results[tempcount])
			document.getElementById('left').style.visibility='hidden';
		}
	}
 

	
	  
			
			
