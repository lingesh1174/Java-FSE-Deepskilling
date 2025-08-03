import sr1 from './office.jpg';
import sr2 from './sr2.jpg';
import sr3 from './sr3.webp';
import sr4 from './sr4.webp';
import sr5 from './sr5.jpg';
import './OfficeRental.css'

const OfficeRental = () => {
  const element = "Office Space";
  const ItemName = { Name:"DBS", Rent: 50000, Address: "Chennai", Image: sr1};
  const ItemList = [
    { Name: "Skyview Corporate", Rent: 57000, Address: "Chennai", Image: sr2},
    { Name: "Zenith Plaza", Rent: 70000, Address: "Hyderabad", Image: sr3},
    { Name: "NeoWork Tower", Rent: 62000, Address: "Bangalore", Image: sr4},
    { Name: "TechEdge Hub", Rent: 58000, Address: "Delhi", Image: sr5}
  ];

  const getRentStyle =(rent)=>({
    color: rent < 60000 ? 'red' : 'green',
  });

  return (
    <div className='office'>
      <h1>{element} ,at Affordable Range</h1>
      <img src={ItemName.Image} width="25%" height="25%" alt="Office Space"/>
      <h1>Name: {ItemName.Name}</h1>
      <h3>Rent: <span style={getRentStyle(ItemName.Rent)}>{ItemName.Rent}</span></h3>
      <h3>Address: {ItemName.Address}</h3>

      <h1>Other {element}s</h1>
      <div className='otherOffices'>
        {ItemList.map((item, index) => (
            <div key={index} className='officeBox'>
            <img src={item.Image} width="50%" height="50%" alt="Office Space"/>
            <h1>Name: {item.Name}</h1>
            <h3><span style={getRentStyle(item.Rent)}>Rent: {item.Rent}</span></h3>
            <h3><strong>Address:</strong> {item.Address}</h3>
            </div>
        ))}
      </div>  
    </div>
  );
};

export default OfficeRental;