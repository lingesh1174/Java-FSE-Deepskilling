import { useState } from "react";

function ComplaintRegister(){
    const [transactionId,setTransactionId] = useState(0);
    const [name,setName] = useState();
    const [complaint,setComplaint] = useState();

    const handleSubmit=(e)=>{
        e.preventDefault();
        const newId = transactionId + 1;
        setTransactionId(newId);
        alert(`Thanks ${name}\nYour Complaint was Submitted.\nTransaction ID is: ${newId}`);
        setName('');
        setComplaint('');
    }

    return(
        <div>
            <h1 className="form-heading">Register your complaints here!!!</h1>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label>Name:</label>
                    <input
                    type="text"
                    value={name}
                    onChange={(e)=>setName(e.target.value)}
                    />
                </div>
                <div className="form-group">
                    <label>Complaint:</label>
                    <textarea
                    value={complaint}
                    onChange={(e)=>setComplaint(e.target.value)}
                    />
                </div>
                <div className="form-group">
                    <button type="submit">Submit</button>
                </div>
            </form>
        </div>
    )
}

export default ComplaintRegister;