import { Component } from "react";
import styled from 'styled-components'

class Job extends Component {
  render() {
    const { name, until, tags } = this.props;
    const tagList = tags.map(tag => <button>#{tag}</button>);

    return (
      <StyledJob>
        <StyledJobName>{name}</StyledJobName>
        <StyledJobUntil>{until}</StyledJobUntil>
        <StyledJobTags>{tagList}</StyledJobTags>
      </StyledJob>
    )
  }
}

export default Job;


const StyledJob = styled.div`
  background: white;
  width: 512px;
  box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);
  /* 그림자 */
  margin: 0 auto;
  /* 페이지 중앙 정렬 */
  margin-top: 4rem;
`;

const StyledJobName = styled.div`
  font-size: 2.5rem;
  text-align: center;
  font-weight: 600;
`;

const StyledJobUntil = styled.div`
  text-align: center;
`;

const StyledJobTags = styled.span`
  text-align: center;

  button {
    margin: 8px;
    border: none;
    background: transparent;
    &:hover {
      cursor: pointer;
    }
  }
`;