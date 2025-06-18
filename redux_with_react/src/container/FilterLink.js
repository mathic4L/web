import { connect } from 'react-redux';
import {setVisibilityFilterAction} from '../actions';
import {Link} from '../view/Link';

const mapStateToProps = (state, ownProps) => {
    return {
        active: ownProps.filter === state.visibilityFilter,
    };
};

const mapDispatchToProps = (dispatch, ownProps) => {
    return {
        onClick: () => {
            dispatch(setVisibilityFilterAction(ownProps.filter));
        },
    };
};

export const FilterLink = connect(
    mapStateToProps,
    mapDispatchToProps
)(Link);

