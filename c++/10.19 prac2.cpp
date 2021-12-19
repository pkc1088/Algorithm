#include <iostream>

int Func(int a)
{
	return a;
}

int Func2(int a=2, int b=3);

int main(void)
{
	int val1=10, val2=20;
	char ch, str[100];
	
	std::cout<<Func(val1)<<std::endl;
	std::cout<<Func2()<<std::endl;
	std::cout<<Func2(100,7)<<std::endl;	
	
	return 0;
}

int Func2(int a, int b)
{
	return a+b;
}

