


<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/bookstore/css/stylesheet.css;jsessionid=d34c9604841637f4dfacd287fea7" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Amu-Darya Bookstore</title>
    </head>
    <header>
        <a href="/bookstore/;jsessionid=d34c9604841637f4dfacd287fea7" > <img src="/bookstore/img/amudarya.png;jsessionid=d34c9604841637f4dfacd287fea7" /> </a>
        <span class="view-cart-link"><a href="/bookstore/viewCart.do;jsessionid=d34c9604841637f4dfacd287fea7">View cart</a></span>
    </header>
    <body>
<div class="container">
<h1>Add Credit Card</h1>
	<div class="general-form">
    <form action="addCreditCard.do" method="post">
    	<table class="general-table">
        <tr>
            <td><label for="creditCardNumber">Credit Card Number: </label></td>
            <td><input id="creditCardNumber" name="creditCardNumber" type="text" value="" /></td>
            
        </tr>
        <tr>
            <td><label for="cardholderName">Cardholder's name: </label></td>
            <td><input id="cardholderName" name="cardholderName" type="text" value="" /></td>
            
        </tr>
        <tr>
            <td><label for="expiryDate">Expiry date: </label></td>
            <td><select id="expiryDate" name="expiryMonth">
                <option value="0">1</option>
                <option value="1">2</option>
                <option value="2">3</option>
                <option value="3">4</option>
                <option value="4">5</option>
                <option value="5">6</option>
                <option value="6">7</option>
                <option value="7">8</option>
                <option value="8">9</option>
                <option value="9">10</option>
                <option value="10">11</option>
                <option value="11">12</option>
            </select>
            /
            <select id="expiryDate" name="expiryYear">
                
            </select>
            </td>
            
        </tr>
        </table>
        <div><input type="submit" value="Submit" /></div>
    </form>
    </div>
    
</div>    </body>
</html>
