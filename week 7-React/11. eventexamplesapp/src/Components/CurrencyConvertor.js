import { useState } from 'react';

const CurrencyConvertor = () => {
    const [rupees, setRupees] = useState();
    const [currency, setCurrency] = useState('');

    const handleSubmit = (event) => {
        if(currency === 'Euro'){
            const euroValue = (parseFloat(rupees) / 90).toFixed(2);
            alert("Converting to Euro amount is : "+ euroValue);
        }
        else
            alert("Given currency is invalid...");
    };

    return (
        <div>
        <h1 style={{color:'green'}}>Currency Converter!!!</h1>
        <form onSubmit={handleSubmit}>
            <label>Amount: </label>
            <input
            type="number"
            value={rupees}
            onChange={(e) => setRupees(e.target.value)}
            placeholder="Enter amount in INR"
            />
            <br/>
            <label>Currency: </label>
            <input 
            type="text"
            value={currency}
            onChange={(e) => setCurrency(e.target.value)}
            placeholder="Enter Euro"
            />
            <br/>
            <button type="submit" style={{marginLeft:'100px', marginTop:'20px'}}>Submit</button>
        </form>
        </div>
    );
};

export default CurrencyConvertor;