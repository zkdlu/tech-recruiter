import { Component } from "react";
import Job from "./Job";


class JobList extends Component {
  render() {
    const { jobOpenings } = this.props;
    const jobList = jobOpenings.map(
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