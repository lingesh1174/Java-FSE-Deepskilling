import React from 'react';
import './Cart.css'

class Cart extends React.Component{
  render(){
    return(
        <center>
        <table class = 'tb'>
            <tr>
                <th>Item Name</th>
                <th>Price</th>
            </tr>
            {this.props.item.map((item, index)=>{
                return(
                    <tr key={index}>
                        <td>{item.itemname}</td>
                        <td>{item.price}</td>
                    </tr>
                );
            })}
        </table>
        </center>  
    );
  }
}

export default Cart;