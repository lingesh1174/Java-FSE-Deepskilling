import React from 'react';
import './CountPeople.css';

class CountPeople extends React.Component{
    constructor(){
        super();
        this.state={
            entryCount:0,
            exitCount:0,
            c:0
        };
        this.updateEntry = this.updateEntry.bind(this);
        this.updateExit = this.updateExit.bind(this);  
    }
    updateEntry(){
        this.setState((prevState)=>{
            return {entryCount:prevState.entryCount+1}
        });
    }
    updateExit(){
        this.setState((prevState)=>{
            return {exitCount:prevState.exitCount+1}
        });
    }
    render(){
        return(
            <div>
                <button onClick={this.updateEntry}>Login</button>
                {this.state.entryCount} People Entered!!!
                <button onClick={this.updateExit}>Exit</button>
                {this.state.exitCount} People Exited!!!
            </div>
        );
    }
}

export default CountPeople;