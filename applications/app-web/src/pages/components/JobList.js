import { Component } from "react";
import Job from "./Job";


class JobList extends Component {
  render() {
    const { jobOpenings } = this.props;
    const jobList = jobOpenings.map(
      ({id, name, until, url, tags}) => (
        <Job 
          key={id}
          name={name}
          until={until}
          url={url}
          tags={tags}/>));

    return (
      <div>
        {jobList}
      </div>
    )
  }
}

export default JobList;