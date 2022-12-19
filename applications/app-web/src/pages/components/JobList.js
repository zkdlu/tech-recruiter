import { Component } from "react";
import styled from 'styled-components'
import Job from "./Job";


class JobList extends Component {
  render() {
    const { jobs } = this.props;

    console.log(jobs);
    const jobList = jobs.map(
      ({id, name, until, tags}) => (
        <Job 
          key={id}
          name={name}
          until={until}
          tags={tags}/>));

    return (
      <div>
        {jobList}
      </div>
    )
  }
}

export default JobList;