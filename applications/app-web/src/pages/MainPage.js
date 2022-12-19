import { Component } from "react";
import api from '../api'
import Layout from "./components/Layout";
import MainBanner from "./components/MainBanner";
import MainContents from "./components/MainContents";

class MainPage extends Component {
    state = {
        companies: []
    }

    async componentDidMount() {
        await this.fetchCompanies();
    }

    async fetchCompanies() {
        const companies = await api.get('companies');
        console.log(companies)
        this.setState({
            companies: [...companies]
        })
    }

    render() {
        return (
            <Layout>
                <MainBanner/>
                <MainContents/>
            </Layout>
        )
    }
}

export default MainPage;