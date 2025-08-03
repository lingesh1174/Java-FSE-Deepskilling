import { useState, useEffect } from "react";

function Getuser(){
  const [person, setPerson] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(()=>{
    async function fetchUser() {
      const url = "https://api.randomuser.me/";
      const response = await fetch(url);
      const data = await response.json();
      setPerson(data.results[0]);
      setLoading(false);
      console.log(data.results[0]);
    }
    fetchUser();
  }, []);

  if(loading){
    return <h2>Loading...</h2>;
  }

  return(
    <div>
      <h2>{person.name.title} {person.name.first} {person.name.last}</h2>
      <img src={person.picture.large} alt="User"/>
    </div>
  );
}

export default Getuser;