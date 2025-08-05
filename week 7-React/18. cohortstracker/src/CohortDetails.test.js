import { shallow, mount } from 'enzyme';
import CohortDetails from './CohortDetails';
import { CohortsData } from './Cohort';

describe("Cohort Details Component", () =>{

  const sampleCohort = CohortsData[0];

  test("should create the component", () =>{
    const wrapper = shallow(<CohortDetails cohort={sampleCohort} />);
    expect(wrapper.exists()).toBe(true);
  });

  test("should initialize the props", () =>{
    const wrapper = shallow(<CohortDetails cohort={sampleCohort} />);
    expect(wrapper.find('h3').text()).toContain(sampleCohort.cohortCode);
    });


  test("should display cohort code in h3", () =>{
    const wrapper = mount(<CohortDetails cohort={sampleCohort} />);
    expect(wrapper.find('h3').text()).toContain(sampleCohort.cohortCode);
  });

  test("should always render same html", () =>{
    const wrapper = shallow(<CohortDetails cohort={sampleCohort} />);
    expect(wrapper).toMatchSnapshot();
  });

});