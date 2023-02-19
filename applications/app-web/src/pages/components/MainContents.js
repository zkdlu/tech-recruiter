import { Component } from "react";
import CompanyList from './CompanyList'
import styled from 'styled-components'
import JobList from "./JobList";
import LoadButton from "./LoadButton";

class MainContents extends Component {
  render() {
    const { jobStats, jobOpenings, onSelectFilter, onClickMore } = this.props;
    
    return (
      <div>
        <StyledFilterSection>
          <CompanyList onSelectFilter={onSelectFilter} jobStats={jobStats}/>
        </StyledFilterSection>
        <StyledJobSection>
          <JobList jobOpenings={jobOpenings}/>
          <LoadButton onClick={onClickMore}>더 보기</LoadButton>
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