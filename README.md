<div id="top"></div>


<br />
<div align="center">

<h2 align="center">Shopping Basket</h2>
<p>Console application which provides to regular user adding products to basket and purchasing them at the end </p>

</div>



<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#how-to-run">How To Run</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>


## About The Project

The application simulates small shop where there are two types of user roles: administrator role and regular user. Administrator can add products to the shop from which the customer can choose to buy. Regular user rights includes possibility to view all available products in the shop, to add products to the basket and purchase them and seeing actual balance.

As a structure application follows Model-View-Controller architecture. The packages are divided as follows:
- [ ] <strong>db</strong>: This package act like database where the entities such as shop products, users and current logged user are saved.
- [ ] <strong>entities</strong>: Product and User classes are stored here with standard fields, constructors, getters and setters.
- [ ] <strong>repository</strong>: This package is responsible to persist new entities in db as well as read the existing ones and transofrm them in objects.
- [ ] <strong>services</strong>: In this package bussines logic is implemented and contains <strong>validators</strong> package. Services are responsible to catch and handle validators. Type of validators are as follows: 
    * Matching credentials (username and password) when trying to login.
    * Product name, username and user's first name length validation. 
    * Product name and username checking existence. 
    * Product price and user amount data type validation.
    * User password validate it's length, containing minimum one letter and digit and checking for whitespaces.
- [ ] <strong>views</strong>: This package simulates different types of menus options in the console.
- [ ] <strong>controller</strong>: Package implementing connection between <strong>services</strong> and <strong>views</strong> classes.
- [ ] <strong>utls</strong>: Package which contains Helpers class with some helping methods.

      <strong>Main.java</strong>: Application starting point.





<p align="right">(<a href="#top">back to top</a>)</p>



### Built With

* [Java](https://www.java.com/)

<p align="right">(<a href="#top">back to top</a>)</p>


### How To Run

Run Main.java class.

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

You can create new User account after filling register form in Main menu as well as adding new products when you are logged as Administrator.
For convinience in testing the features you can use existing entities such as:
 * Administrator account: 
    - [ ] Username: Admin
    - [ ] Password: admin12345
   
    <p>
    <strong> Note that Admin account is always first and only entity with administrator rights in database </strong> 
    </p>

  * User account with big balance: 
    - [ ] Username: mkk
    - [ ] Password: 12345qwe

  * User account with small balance: 
    - [ ] Username: borisp
    - [ ] Password: 12345qwe
  
  * Existing products

<p align="right">(<a href="#top">back to top</a>)</p>




## Roadmap

<strong>Main menu</strong>
- [ ] Login
   
    <strong>Administrator menu</strong>
    - [ ] Admin role
        - [ ] Add product to shop    
        - [ ] Exit  
   
    <strong>User menu</strong>
    - [ ] User role
        - [ ] Show products   
        - [ ] Add products to basket  
        - [ ] Show products in basket  
        - [ ] Show balance
        - [ ] Purchase    
        - [ ] Exit  

- [ ] User registration 
- [ ] Exit

 

<p align="right">(<a href="#top">back to top</a>)</p>


## Contact

Martin Kokonyan - martin.kokonyan@paysafe.com - +359 883 346 727



<p align="right">(<a href="#top">back to top</a>)</p>

