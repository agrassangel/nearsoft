# nearsoft
1-in Setup class configure the webdriver path location in method InitSetup(). 
  file folder "nearsoft\general"
2-About the test:
When the final test method runs and system sorts the prices by "highest" filter, sometimes, occurres that "listPrices" and "listPricesOld" 
arrays don't have the same size, because elements are missed in the system page. That's why a validation of the size is necessary in 
that method before accepting the equality between them. 
