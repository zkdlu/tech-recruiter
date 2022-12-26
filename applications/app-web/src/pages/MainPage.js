import { Component } from "react";
import api from '../api'
import Layout from "./components/Layout";
import MainBanner from "./components/MainBanner";
import MainContents from "./components/MainContents";

class MainPage extends Component {
    state = {
        jobStats: [],
        jobOpenings: [],
    }

    async componentDidMount() {
        await this.fetchJobStats();
        await this.fetchJobOpenings();
    }

    async fetchJobStats() {
        const jobStats = await api.get('job-stats');
        this.setState({
            jobStats: [...jobStats]
        })
    }

    async fetchJobOpenings() {
        const jobOpenings = await api.get('job-openings');
        this.setState({
            jobOpenings: [...jobOpenings]
        })
    }

    render() {
        const { jobStats, jobOpenings } = this.state;

        return (
            <Layout>
                <MainBanner/>
                <MainContents jobStats={jobStats} jobOpenings={jobOpenings}/>
            </Layout>
        )
    }
}

export default MainPage;