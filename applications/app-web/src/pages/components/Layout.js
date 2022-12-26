import Footer from "./Footer";
import Header from "./Header";
import styled from 'styled-components'

const StyledLayout = styled.div`
display: flex;
flex-direction: column;
justify-content: flex-start;
width: 100%;
min-height: 100vh;
position: relative;
`;

const StyledMain = styled.main`
    min-height: calc(100vh - 180px);
    background: #eff0f3;
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