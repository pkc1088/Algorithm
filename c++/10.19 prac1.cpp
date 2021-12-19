#include <iostream>

int main(void)
{
	int num=1, val1, val2;
	char ch, str[100];
	
	std::cout<<"Enter"<<' '<<num<<' '<<'N'<<std::endl;
	std::cin>>val1>>val2;
	std::cout<<val1+val2<<std::endl;
	std::cin>>ch;
	std::cin>>str;
	std::cout<<ch<<' '<<str<<std::endl;
	return 0;
}
