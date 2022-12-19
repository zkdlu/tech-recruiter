import { Component } from "react";
import CompanyList from './CompanyList'
import styled from 'styled-components'

class MainContents extends Component {
  render() {
    const { jobOpenings, jobs } = this.props;
    const jobList = jobs.map(job => 
    <div>
      <span>{job.name}</span>
      <span>{job.until}</span>
      <span>{job.tags}</span>
    </div>
    );

    return (
      <div>
        <StyledFilterSection>
          <CompanyList jobOpenings={jobOpenings}/>
        </StyledFilterSection>
        <StyledJobSection>
          {jobList}
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