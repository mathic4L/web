import React from 'react';
import {VISIBILITY_FILTER_ALL, VISIBILITY_FILTER_DONE, VISIBILITY_FILTER_TODO} from "../store";
import {FilterLink} from "../container/FilterLink";

export const Footer = () => (
    <div>
        <span>Show: </span>
        <FilterLink filter={VISIBILITY_FILTER_ALL}>
            All
        </FilterLink>
        <FilterLink filter={VISIBILITY_FILTER_TODO}>
            Active
        </FilterLink>
        <FilterLink filter={VISIBILITY_FILTER_DONE}>
            Completed
        </FilterLink>
    </div>
);
