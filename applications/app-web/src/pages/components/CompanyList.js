import { Component } from "react";
import styled from 'styled-components'


class CompanyList extends Component {
  render() {
    const { jobOpenings } = this.props;
    const companyList = jobOpenings.map(jobOpening => 
      <StyledButton>{jobOpening.company}
        <StyledSpan>{jobOpening.count}</StyledSpan>
      </StyledButton>
    );

    return (
        <StyledList>
          {companyList}
        </StyledList>
    )
  }
}

export default CompanyList;

const StyledList = styled.ul`
  display: flex;
  list-style: none;

  li + li {
    margin-left: 30px;
  }
`;

const StyledButton = styled.button`
  margin: 8px;
  font-weight: bold;
  overflow: visible;
  border: none;
  background: transparent;
  &:hover {
    cursor: pointer;
  }
`;

const StyledSpan = styled.span`
  background-color: #002034;
  display: inline-block;
  min-width: 35px;
  height: 24px;
  margin: 0 7px;
  padding: 0 8px;
  font-size: 15px;
  font-weight: 700;
  color: #fff;
  line-height: 1.5;
  border-radius: 12px;
`;