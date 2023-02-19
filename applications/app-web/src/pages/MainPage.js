import { Component } from "react";
import api from '../api'
import Layout from "./components/Layout";
import MainBanner from "./components/MainBanner";
import MainContents from "./components/MainContents";

class MainPage extends Component {
    state = {
        page: 0,
        size: 10,
        jobStats: [],
        jobOpenings: [],
    }

    async componentDidMount() {
        const { size, page } = this.state;

        await this.fetchJobStats();
        await this.fetchJobOpenings(size, page);
    }

    loadMore = async () => {
        const { size, page } = this.state;
        await this.fetchJobOpenings(size, page + 1);
    }

    async fetchJobStats() {
        const jobStats = await api.get('job-openings/stats');
        this.setState({
            jobStats: [...jobStats]
        })
    }

    async fetchJobOpenings(size, page) {
        const jobOpenings = await api.get('job-openings', {
            params: {
                size: size,
                page: page
            }
        });

        this.setState({
            jobOpenings: [...jobOpenings],
            page: page
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
        const { handleFetchJobOpeningsByCompany, loadMore } = this;

        return (
            <Layout>
                <MainBanner />
                <MainContents jobStats={jobStats} jobOpenings={jobOpenings}
                    onSelectFilter={handleFetchJobOpeningsByCompany} onClickMore={loadMore}
                />
            </Layout>
        )
    }
}

export default MainPage;