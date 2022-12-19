import Footer from "./Footer";
import Header from "./Header";
import styled from 'styled-components'

const StyledLayout = styled.div`
  padding-top: 60px;
`;

const StyledMain = styled.main`
    min-height: calc(100vh - 180px);
`;

const Layout = ({children}) => {
    return (
        <StyledLayout>
            <Header/>
            <StyledMain>
                {children}
            </StyledMain>
            <Footer/>
        </StyledLayout>
    )

}

export default Layout;