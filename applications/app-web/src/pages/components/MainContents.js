import { Component } from "react";
import CompanyList from './CompanyList'
import styled from 'styled-components'
import JobList from "./JobList";

class MainContents extends Component {
  render() {
    const { jobStats, jobOpenings } = this.props;
    
    return (
      <div>
        <StyledFilterSection>
          <CompanyList jobStats={jobStats}/>
        </StyledFilterSection>
        <StyledJobSection>
          <JobList jobOpenings={jobOpenings}/>
        </StyledJobSection>
      </div>
    )
  }
} 

export default MainContents;

const StyledFilterSection = styled.section`
  margin: 16px;
  padding: 16px;
`;

const StyledJobSection = styled.section`
  margin: 16px;
  padding: 16px;
`;