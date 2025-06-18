const createTaskFabric = ()=>{
    let counter = 0
    return ({name, description})=>{
        return {id: counter++, name, description, creationDate: '', lastUpdate: ''}
    }
}

export {createTaskFabric}