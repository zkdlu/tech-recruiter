import { Component } from "react";
import api from '../api'
import Layout from "./components/Layout";
import MainBanner from "./components/MainBanner";
import MainContents from "./components/MainContents";

class MainPage extends Component {
    state = {
        jobOpenings: [],
        jobs: [{
            name: '공고1',
            until: '2022-12-31',
            tags: ['tag1', 'tag2']
        }],
    }

    async componentDidMount() {
        await this.fetchJobOpenings();

        const { jobs } = this.state;

        for (let i = 2; i < 100; i++) {
            jobs.push({
                name: '공고' + i,
                until: '2022-12-31',
                tags: ['tag1', 'tag2']
            })
        }
    }

    async fetchJobOpenings() {
        const jobOpenings = await api.get('job-openings');
        console.log(jobOpenings)
        this.setState({
            jobOpenings: [...jobOpenings]
        })
    }

    render() {
        const { jobOpenings, jobs } = this.state;

        return (
            <Layout>
                <MainBanner/>
                <MainContents jobOpenings={jobOpenings} jobs={jobs}/>
            </Layout>
        )
    }
}

export default MainPage;