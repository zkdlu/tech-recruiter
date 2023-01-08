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
        const jobStats = await api.get('job-openings/stats');
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

    handleFetchJobOpeningsByCompany = async (company) => {
        const jobOpenings = await api.get(`job-openings/${company}`);
        this.setState({
            jobOpenings: [...jobOpenings]
        })
    }

    render() {
        const { jobStats, jobOpenings } = this.state;
        const { handleFetchJobOpeningsByCompany } = this;

        return (
            <Layout>
                <MainBanner />
                <MainContents jobStats={jobStats} jobOpenings={jobOpenings}
                    onSelectFilter={handleFetchJobOpeningsByCompany}
                />
            </Layout>
        )
    }
}

export default MainPage;