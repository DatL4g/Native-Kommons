package dev.datlag.kommons


data object Ethiopia : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("ET")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("ETH")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(231)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(251)
}