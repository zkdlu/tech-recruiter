import { Component } from "react";
import api from '../api'
import Layout from "./components/Layout";
import MainBanner from "./components/MainBanner";
import MainContents from "./components/MainContents";

class MainPage extends Component {
    state = {
        jobOpenings: [],
        jobs: [],
    }

    async componentDidMount() {
        await this.fetchJobOpenings();

        const { jobs } = this.state;

        for (let i = 1; i < 100; i++) {
            jobs.push({
                id: i,
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